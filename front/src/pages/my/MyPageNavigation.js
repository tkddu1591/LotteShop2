import {changeDTO} from "../../store/changeDTO";

function MyPageNavigation({pageResponseDTO, setPageRequestDTO, setAnswerCheck}) {
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
            <a onClick={() => {
                if (pageResponseDTO.qnaDTOS !== null)
                    setAnswerCheck({
                        1: false,
                        2: false,
                        3: false,
                        4: false,
                        5: false,
                        6: false,
                        7: false,
                        8: false,
                        9: false,
                        10: false,
                    })
                changeDTO(setPageRequestDTO, 'pg', start - 1)
            }}
               style={{cursor: 'pointer', userSelect: 'none'}} className="prev"> &lt; 이전 </a>
        }


        {no.map((item, index) => {
            return <a key={index}
                      onClick={() => {
                          changeDTO(setPageRequestDTO, 'pg', item)
                          if (pageResponseDTO.qnaDTOS !== null)
                              setAnswerCheck({
                                  1: false,
                                  2: false,
                                  3: false,
                                  4: false,
                                  5: false,
                                  6: false,
                                  7: false,
                                  8: false,
                                  9: false,
                                  10: false,
                              })
                      }}
                      style={{cursor: 'pointer', userSelect: 'none'}}
                      className={pg === item ? 'num on' : 'num'}>{item}</a>
        })}


        {next &&
            <a onClick={() => {
                changeDTO(setPageRequestDTO, 'pg', end + 1)
                if (pageResponseDTO.qnaDTOS !== null)
                    setAnswerCheck({
                        1: false,
                        2: false,
                        3: false,
                        4: false,
                        5: false,
                        6: false,
                        7: false,
                        8: false,
                        9: false,
                        10: false,
                    })
            }}
               style={{cursor: 'pointer', userSelect: 'none'}} className="next"> 다음 &gt;</a>
        }

    </p>
}

export default MyPageNavigation;