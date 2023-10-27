import React from "react";

function QnaPopup({setPopup, item, member}){
    // 31: 상품
    let [qnaCate, setQnaCate] = React.useState()
    let [qnaType, setQnaType] = React.useState()
    let [qna, setQna] = React.useState({
        title: '',
        content: '',
        email: '',
        cate: '',
        type: '',
        writer:member.uid
    })
    return <>
        <div id="popSeller" className="popup">
            <div>
                <nav>
                    <h1>판매자 정보</h1>
                    <button className="btnClose" onClick={() => {
                        setPopup('')
                    }}>X
                    </button>
                </nav>
                <section>
                    <table border="0">
                        <tbody>
                            <tr>
                                <th style={{height:'35px'}}>문의 종류</th>
                                <select style={{marginTop:'10px', marginLeft:'5px'}}>
                                    <option>1차 분류</option>
                                </select>
                                <select style={{marginTop:'10px', marginLeft:'5px'}}>
                                    <option>2차 분류</option>
                                </select>
                            </tr>
                            <tr>
                                <th>Email</th>
                                <input className="company" value={member.email}></input>
                            </tr>
                            <tr>
                                <th>대표자</th>
                                <td className="ceo">{item.ceo}</td>
                            </tr>
                            <tr>
                                <th>전화번호</th>
                                <td className="tel">{item.tel}</td>
                            </tr>
                            <tr>
                                <th>FAX</th>
                                <td className="fax">{item.fax}</td>
                            </tr>
                            <tr>
                                <th>Email</th>
                                <td className="email">{item.email}</td>
                            </tr>
                            <tr>
                                <th>사업자번호</th>
                                <td className="bizNum">{item.bizRegNum}</td>
                            </tr>
                            <tr>
                                <th>영업소재지</th>
                                <td className="address">
                                    [210**] 부산광역시 부산진구 대연동 121 10층 1004호
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <p>
                        ※ 위 정보는 전자상거래법 제 20조 제 2항 및 동법 시행령 제 25조 제 2항에 의거하여<br/>
                        소비자보호에 의거 공개합니다.
                    </p>

                    <div>
                        <button className="btnPositive btnQuestion"
                                style={{fontFamily: '함초롱바탕', width: '100px', height: '30px'}}
                                onClick={() => {
                                    setPopup('qna')
                                }}
                        >문의하기
                        </button>
                    </div>

                </section>
            </div>
        </div></>
}
export default QnaPopup