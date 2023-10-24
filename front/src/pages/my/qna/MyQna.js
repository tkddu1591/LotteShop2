import {Link} from "react-router-dom";
import {changeDTO} from "../../../store/changeDTO";
import React, {useState} from "react";
import MyPageNavigation from "../MyPageNavigation";

function MyQna({pageResponseDTO, setPageRequestDTO}) {
    function answer(value) {
        if (value === 0) {
            return <td className="status"><span style={{color: 'grey'}}>미확인</span></td>
        }
        if (value === 1) {
            return <td className="status"><span style={{color: '#8972EE'}}>검토중</span></td>
        }
        if (value === 2) {
            return <td className="status"><span className="answered">답변완료</span></td>
        }
    }

    function content(value, setAnswerCheck, index) {
        if (value.cate === 'cancel' || value.cate === 'delivery' || value.cate === 'order' || value.cate === 'safe') {
            return <td className="tit">
                <ul>
                    <li className="prodName"><Link
                        to={`${process.env.REACT_APP_HOME_URL}/product/view?prodNo=` + value.prodNo}>{value.prodName}</Link>
                    </li>
                    {value.answerComplete === 2 ? <li className="question"><span style={{cursor: 'pointer'}}
                                                                                 onClick={() => changeDTO(setAnswerCheck, index, !answerCheck[index])}
                    >{value.title}</span></li> : <li className="question">{value.title}</li>}
                </ul>
            </td>
        } else {
            return <>
                {value.answerComplete === 2 ? <td className="tit"><span style={{cursor: 'pointer'}}
                                                                        onClick={() => changeDTO(setAnswerCheck, index, !answerCheck[index])}>{value.title}</span>
                </td> : <td className="tit">{value.title}</td>}</>
        }
    }

    let [answerCheck, setAnswerCheck] = useState({
        1: false, 2: false, 3: false, 4: false, 5: false, 6: false, 7: false, 8: false, 9: false, 10: false,
    });
    return <>
        <article>
            <h3>문의하기</h3>

            <table border="0">
                <tbody>
                    <tr>
                        <th style={{width: '30px'}}>번호</th>
                        <th style={{width: '80px'}}>문의채널</th>
                        <th style={{width: '100px'}}>문의유형</th>
                        <th style={{width: '200px'}}>제목</th>
                        <th style={{width: '80px'}}>작성일</th>
                        <th style={{width: '50px'}}>상태</th>
                    </tr>
                    {Array.isArray(pageResponseDTO.qnaDTOS) && pageResponseDTO.qnaDTOS.map((qna, index) => {
                        return <>
                            <tr key={index}>
                                <td className="no">{pageResponseDTO.total - index - pageResponseDTO.pg * 10 + 10}</td>
                                <td className="channel">{qna.cateName}</td>
                                <td className="type">{qna.typeName}</td>
                                {content(qna, setAnswerCheck, index)}
                                <td className="date">{qna.rdate.substring(0, 10)}</td>
                                {answer(qna.answerComplete)}
                            </tr>
                            {qna.answerComplete === 2 && answerCheck[index] &&
                                <tr className="answerRow" key={index + 'answer'}>
                                    <td colSpan="6">
                                        <div className="question">
                                            <p className="tit">
                                                {qna.title}
                                                <span
                                                    className="date">{qna.rdate.substring(0, 10)} {qna.rdate.substring(11, 20)}</span>
                                            </p>
                                            <p className="content">
                                                {qna.content}
                                            </p>
                                        </div>
                                        <div className="answer">
                                            <p className="tit">
                                                {qna.typeName} 문의 답변입니다.
                                                <span
                                                    className="date">{qna.answerDate.substring(0, 10)} {qna.answerDate.substring(11, 20)}</span>
                                            </p>
                                            <p className="content">
                                                {qna.answer}
                                            </p>
                                        </div>
                                    </td>
                                </tr>}
                        </>
                    })}
                </tbody>
            </table>

            <MyPageNavigation pageResponseDTO={pageResponseDTO}
                              setPageRequestDTO={setPageRequestDTO}></MyPageNavigation>
        </article>
    </>
}
export default MyQna;