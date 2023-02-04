import FormCadastro from 'components/FormCadastro';
import FormCard from 'components/FormCard';
import { useParams } from 'react-router-dom';

function Form() {
    const params = useParams();

    return (
        <FormCadastro/>
    );
}

export default Form;