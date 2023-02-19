import axios, { AxiosRequestConfig } from 'axios';
import { useNavigate } from 'react-router-dom';
import { BASE_URL } from 'utils/requests';
import './styles.css';
import PhoneInput from 'react-phone-input-2'
import 'react-phone-input-2/lib/style.css'



/* 
type Props = {
    movieId: String;
} */

function FormUser() {

    const navigate = useNavigate();

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const username = (event.target as any).username.value;
        const password = (event.target as any).password.value

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: 'POST',
            url: '/user',
            data: {
                username: username,
                password: password
            }
        }

        axios(config).then(response =>{
            navigate("/");
        });
    }

    return (
        <div className="eucalipto-form-container">

            <div className="eucalipto-card-bottom-container">
                <h3>Crie sua conta no Eucalipto</h3>
                <img className="eucalipto-movie-card-image" src={"https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/5eeea355389655.59822ff824b72.gif"} alt={"Yggdrasil"} />
                <form className="eucalipto-form" onSubmit={handleSubmit}>
                    <div className="form-group eucalipto-form-group">

                        <label htmlFor="username">Informe seu email</label>
                        <input type="username" className="form-control" id="username" />

                        <label htmlFor="password">Informe sua senha: </label>
                        <input type="password" className="form-control" id="password" />

                        <label htmlFor="passwordConfirmation">Confirme a senha digitada: </label>
                        <input type="password" className="form-control" id="passwordConfirmation" />
                    </div>


                    <div className="eucalipto-form-btn-container">
                        <button type="submit" className="btn btn-primary eucalipto-btn">Cadastrar</button>
                    </div>
                </form >
            </div >
        </div >
    );
}

export default FormUser;