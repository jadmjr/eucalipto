import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Listing from 'pages/Listing';
import Form from 'pages/Form';
import Navbar from "components/Navbar";
import RegisterForm from "pages/RegisterForm";
import Inicial from "pages/Inicial";
import ReactGA from 'react-ga';
import Cadastro from "pages/Cadastro";
import Footer from "components/Footer";
const TRACKING_ID = "G-8CFNCSK96H"; // OUR_TRACKING_ID
ReactGA.initialize(TRACKING_ID);

function App() {
  return (
    <BrowserRouter>
      <Navbar />

      <Routes>
        <Route path="/" element={<Listing />} />
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/form">
          <Route path=":movieId" element={<Form />} />
        </Route>
        <Route path="/inicial">
          <Route path=":movieId" element={<Inicial />} />
        </Route>
        <Route path="/register">
          <Route path=":movieId" element={<RegisterForm />} />
        </Route>
      </Routes>
      <Footer />
    </BrowserRouter>
    
  );
}

export default App;