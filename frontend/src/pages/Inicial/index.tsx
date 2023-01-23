import FormCard from 'components/FormCard';
import { useParams } from 'react-router-dom';

function Inicial() {
    const params = useParams();

    return (
        <FormCard movieId={`${params.movieId}`} />
    );
}

export default Inicial;