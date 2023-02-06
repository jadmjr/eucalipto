import axios, { AxiosRequestConfig } from 'axios';
import { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Movie } from 'types/movies';
import { BASE_URL } from 'utils/requests';
import { validateEmail } from 'utils/validate';
import './styles.css';
import PhoneInput from 'react-phone-input-2'
import 'react-phone-input-2/lib/style.css'
import { Person } from 'types/person';


/* 
type Props = {
    movieId: String;
} */

function FormCadastro() {

    const navigate = useNavigate();
    const [person, setPerson] = useState<Person>();

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const email = (event.target as any).email.value;
        const name = (event.target as any).name.value
        const familyName = (event.target as any).familyName.value;
        const phoneNumber = (event.target as any).phoneNumber.value;
 
        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: 'POST',
            url: '/person',
            data: {
                email: email,
                name: name,
                familyName:familyName,
                phoneNumber: phoneNumber
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

                        <label htmlFor="name">Informe seu primeiro nome</label>
                        <input type="text" className="form-control" id="name" />

                        <label htmlFor="familyName">Informe seu sobrenome</label>
                        <input type="text" className="form-control" id="familyName" />


                        <label htmlFor="phoneNumber">Informe seu telefone</label>
                        <PhoneInput
                        inputProps={{
                            name: 'phoneNumber',
                            required: true,
                            autoFocus: true
                          }}
                            onlyCountries={['br']}
                            masks={{ br: '(..) .....-....' }}
                            country='br'
                            regions={'america'}
                            inputClass={"bubu"}
                            

                        />

                        <label htmlFor="email">Informe seu email</label>
                        <input type="email" className="form-control" id="email" />

                    </div>


                    <div className="eucalipto-form-btn-container">
                        <button type="submit" className="btn btn-primary eucalipto-btn">Cadastrar</button>
                    </div>
                </form >
            </div >
        </div >
    );
}

export default FormCadastro;