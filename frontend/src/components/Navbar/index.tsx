import {ReactComponent as GithubIcon} from 'assets/img/github.svg'
import "./styles.css"

function Navbar(){
    return(
        <header>
        <nav className="container">
          <div className="eucalipto-nav-content">
            <h1>Eucalipto</h1>
            <a href="https://github.com/jadmjr" target="_blank" rel="noreferrer">
              <div className="eucalipto-contact-container">
                <GithubIcon />
                <p className="eucalipto-contact-link">/eucalipto</p>
              </div>
            </a>
          </div>
        </nav>
      </header>
    )
}

export default Navbar;