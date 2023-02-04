/* import axios, { AxiosRequestConfig } from 'axios';
import { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Movie } from 'types/movies';
import { BASE_URL } from 'utils/requests';
import { validateEmail } from 'utils/validate'; */
import './styles.css';
import PhoneInput from 'react-phone-input-2';
import 'react-phone-input-2/lib/style.css';

/* 
type Props = {
    movieId: String;
} */

function FormCadastro() {
    return (
        <div className="eucalipto-form-container">
    
            <div className="eucalipto-card-bottom-container">
                <h3>Eucalipto Apostas</h3>
                <img className="eucalipto-movie-card-image" src={"https://thumbs.gfycat.com/SmallDiscreteGnat-small.gif"} alt={"Koala Feliz"} />
                <form className="eucalipto-form" >
                    <div className="form-group eucalipto-form-group">
                    
                        <label htmlFor="fullName">Informe seu nome completo</label>
                        <input type="text" className="form-control" id="fullName" />

                        <label htmlFor="fullName">Escolha seu usuário</label>
                        <input type="text" className="form-control" id="fullName" />


                        <label htmlFor="phoneNumber">Informe seu telefone</label>
                        <PhoneInput
                            inputProps={{
                                name: 'phoneNumber',
                                required: true,
                                autoFocus: true,
                                placeholder: "informe seu telefone"



                            }}
                            country={'br'}
                        />
                        <label htmlFor="email">Informe seu email</label>
                        <input type="email" className="form-control" id="email" />

                        <br></br>

                        <div className="form-control">
                            <label htmlFor="email">Informe seu CPF</label>

                        </div>

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