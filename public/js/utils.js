document.addEventListener("DOMContentLoaded", () => {
    document.body.insertAdjacentHTML('afterbegin', `
        <nav class="navbar navbar-expand-lg bg-body-tertiary mb-3 boja1">
            <div class="container">
                <a class="navbar-brand" href="index.html">
                    <i class="fa-solid fa-futbol"></i>World Cup 2026
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mb-2 mb-lg-0 justify-content-center w-100">
                        <li class="nav-item">
                            <a class="nav-link" href="index.html">
                                <i class="fa-solid fa-house"></i> Home
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="teams.html">
                                <i class="fa-solid fa-flag"></i> Teams
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="players.html">
                                <i class="fa-solid fa-users"></i> Players
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="games.html">
                                <i class="fa-solid fa-calendar"></i> Games
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    `)
})

const bootstrapClasses = {
    popup: 'card',
    cancelButton: 'btn btn-danger',
    denyButton: 'btn btn-secondary',
    confirmButton: 'btn btn-primary'
}

function showLoading() {
    Swal.fire({
      title: 'Podaci se učitavaju',
      text: 'Molimo sačekajte dok dopremimo najsvežije podatke.',
      allowOutsideClick: false,
      customClass: bootstrapClasses,
      didOpen: () =>{
      Swal.showLoading()
      }
    })
}

function showConfirm(msg, callback) {
    Swal.fire({
        title: msg,
        showCancelButton: true,
        confirmButtonText: 'Da, želim',
        cancelButtonText: 'Ne, odustani',
        icon: "question",
        customClass: bootstrapClasses
    }).then(result => {
        if (result.isConfirmed) {
            callback()
            Swal.fire({
                title: "Uspešno izvršeno",
                confirmButtonText: 'Uredu',
                icon: "success",
                customClass: bootstrapClasses
            })
        }
    })
}

async function retrieveData(url, callback) {
    showLoading()
    const rsp = await fetch(url)
    const data = await rsp.json()
    callback(data)
    Swal.close()
}