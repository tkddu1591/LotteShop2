import React from "react";

function SellerData({setPopup, item}) {

    function levelCheck(value) {
        if (value === 6) {
            return <td><img  src={`${process.env.REACT_APP_HOME_URL}/images/ico_power_dealer.gif`} alt="파워"/></td>
        } else if (value === 7) {
            return <td><img  src={`${process.env.REACT_APP_HOME_URL}/images/ico_great_seller.gif`} alt="그레이트"/></td>
        } else if (value === 8) {
            return <td>
                <img src={`${process.env.REACT_APP_HOME_URL}/images/ico_great_seller.gif`} alt="파워"/>
                <img src={`${process.env.REACT_APP_HOME_URL}/images/ico_power_dealer.gif`} alt="그레이트"/>
            </td>
        } else {

            return <td className="level">일반판매자</td>
        }
    }

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
                                <th style={{height:'35px'}}>판매자 등급</th>
                                {levelCheck(item.level)}
                            </tr>
                            <tr>
                                <th>상호</th>
                                <td className="company">{item.company}</td>
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
        </div>
    </>
}

export default SellerData