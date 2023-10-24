import React from "react";

function Qna({userQna}) {
    return <>
        <article className="qna">
            <h3>문의내역</h3>
            <a href="#" className="more">더보기</a>
            <table border="0">
                <tbody>
                    <tr>
                        <th>번호</th>
                        <th>문의채널</th>
                        <th>문의유형</th>
                        <th>제목</th>
                        <th>작성일</th>
                        <th>상태</th>
                    </tr>
                    {userQna.map((item, index) => {
                        return <>
                            <tr key={index}>
                                <td>{item.qnaNo}</td>
                                <td>{item.cateName}</td>
                                <td>{item.typeName}</td>
                                <td>{item.content}</td>
                                <td>{item.rdate.substring(0, 10)}</td>
                                <td><span
                                    className="notAnswerYet">{item.answerComplete === 1 ? '검토중' : item.answerComplete === 2 ? '답변완료' : '확인중'}</span>
                                </td>
                            </tr>
                        </>
                    })}
                </tbody>
            </table>
        </article>
    </>
}
export default Qna;