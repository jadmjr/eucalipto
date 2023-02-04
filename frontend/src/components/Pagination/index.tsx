import { ReactComponent as Arrow } from 'assets/img/arrow.svg'
import { MoviePage } from 'types/movies';
import "./styles.css"

type Props = {
  page: MoviePage;
  onChange: Function;
}

function Pagination({ page, onChange }: Props) {
  return (
    <div className="eucalipto-pagination-container">
      <div className="eucalipto-pagination-box">
        <button className="eucalipto-pagination-button" disabled={page.first} onClick={() => onChange(page.number - 1)}>
          <Arrow />
        </button>        
        <p>{`${page.number +1} de ${page.totalPages}`}</p>
        <button className="eucalipto-pagination-button" disabled={page.last} onClick={() => onChange(page.number + 1)}>
          <Arrow className="eucalipto-flip-horizontal" />
        </button>
      </div>
    </div>
  );
}

export default Pagination;