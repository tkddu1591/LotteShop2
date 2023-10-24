import React from "react";


function Point({userPoint, setDivName}) {
    return <article className="point">
        <h3>포인트적립내역</h3>
        <a onClick={() => {
            setDivName('point')
        }} className="more">더보기</a>
        <table border="0" key="point">
            <tbody>
                <tr>
                    <th>날짜</th>
                    <th>구분</th>
                    <th>주문번호</th>
                    <th>적립금액</th>
                    <th>비고</th>
                    <th>유효기간</th>
                </tr>
                {userPoint.map((item, index) => {
                    return <tr key={index}>
                        <td>{item.ordDate.substring(0, 10)}</td>
                        <td>적립</td>
                        <td>{item.ordNo.toLocaleString()}</td>
                        <td>{item.point.toLocaleString()}</td>
                        <td>{item.ordComplete === 2 ? '적립취소' : '적립완료'}</td>
                        <td>{item.pointDate.substring(0, 10)}</td>
                    </tr>
                })}
            </tbody>
        </table>
    </article>
}

export default Point;