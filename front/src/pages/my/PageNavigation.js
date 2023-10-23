import {changeDTO} from "../../store/ChangeDTO";

function PageNavigation({pageResponseDTO, setPageRequestDTO}) {
    let start = pageResponseDTO.start;
    let end = pageResponseDTO.end;
    let next = pageResponseDTO.next;
    let prev = pageResponseDTO.prev;
    let pg = pageResponseDTO.pg;

    let no = []
    for (let i = start; i <= end; i++) {
        no.push(i)
    }

    for(let i = start; i <= end; i++) {
        <div>{i}</div>
    }
    return <div className="paging">

        {prev && <span className="prev">
                <a onClick={() =>changeDTO(setPageRequestDTO,'pg', start - 1)}
                   style={{cursor: 'pointer', userSelect: 'none'}}> &lt; 이전 </a>
            </span>}
        <span className="num">

            {no.map((item, index) => {
                return <a key={index}
                          onClick={() => changeDTO(setPageRequestDTO,'pg', item)} style={{cursor: 'pointer', userSelect: 'none'}}
                          className={pg === item ? 'on' : ''}>{item}</a>
            })}
        </span>

        {next && <span className="">
                <a onClick={() => changeDTO(setPageRequestDTO,'pg', end + 1)}
                   style={{cursor: 'pointer', userSelect: 'none'}}> 다음 &gt;</a>
            </span>}

    </div>
}
