import {ReactComponent as GithubIcon} from 'assets/img/github.svg'
import "./styles.css"
import ReactGA from 'react-ga';
const TRACKING_ID = "G-8CFNCSK96H"; // OUR_TRACKING_ID
ReactGA.initialize(TRACKING_ID);
ReactGA.pageview(window.location.pathname + window.location.search);

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