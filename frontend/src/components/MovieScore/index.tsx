import "./styles.css"
import MovieStars from 'components/MovieStars';

type Props = {
  score : number;
  count : number; 
}   

function MovieScore({score, count}: Props) {
  return (
    <div className="eucalipto-score-container">
      <p className="eucalipto-score-value">{score > 0 ? score.toFixed(1) : '-'}</p>
      <MovieStars score={score}/>
      <p className="eucalipto-score-count">{count} avaliações</p>
    </div>
  );
}
export default MovieScore;