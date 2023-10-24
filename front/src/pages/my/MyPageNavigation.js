import {changeDTO} from "../../store/changeDTO";

function MyPageNavigation({pageResponseDTO, setPageRequestDTO}) {
    let start = pageResponseDTO.start;
    let end = pageResponseDTO.end;
    let next = pageResponseDTO.next;
    let prev = pageResponseDTO.prev;
    let pg = pageResponseDTO.pg;

    let no = []
    for (let i = start; i <= end; i++) {
        no.push(i)
    }

    for (let i = start; i <= end; i++) {
        <div>{i}</div>
    }
    return <p className="page">

        {prev &&
            <a onClick={() => changeDTO(setPageRequestDTO, 'pg', start - 1)}
               style={{cursor: 'pointer', userSelect: 'none'}} className="prev"> &lt; 이전 </a>
        }


        {no.map((item, index) => {
            return <a key={index}
                      onClick={() => changeDTO(setPageRequestDTO, 'pg', item)}
                      style={{cursor: 'pointer', userSelect: 'none'}}
                      className={pg === item ? 'num on' : 'num'}>{item}</a>
        })}


        {next &&
                <a onClick={() => changeDTO(setPageRequestDTO, 'pg', end + 1)}
                   style={{cursor: 'pointer', userSelect: 'none'}} className="next"> 다음 &gt;</a>
            }

    </p>
}

export default MyPageNavigation;