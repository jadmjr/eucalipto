import RegisterFormCard from 'components/RegisterFormCard';
import { useParams } from 'react-router-dom';

function RegisterForm() {
    const params = useParams();

    return (
        <RegisterFormCard movieId={`${params.movieId}`} />
    );
}

export default RegisterForm;