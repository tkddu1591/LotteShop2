import React from "react";


function Point({userPoint, setDivName}) {

    function accumulationCheck(item){
        if(item.point>= 0)
            return <td className="type" style={{color:'green'}}>적립</td>
        else{
            return <td className="type" style={{color:'red'}}>사용</td>
        }
    }
    return <article className="point">
        <h3>포인트적립내역</h3>
        <a onClick={() => {
            setDivName('point')
        }} className="more">더보기</a>
        <table border="0" key="point">
            <tbody>
                <tr>
                    <th style={{width:'120px'}}>날짜</th>
                    <th style={{width:'70px'}}>구분</th>
                    <th style={{width:'100px'}}>주문번호</th>
                    <th style={{width:'70px'}}>적립금액</th>
                    <th >비고</th>
                    <th style={{width:'120px'}}>유효기간</th>
                </tr>
                {userPoint.map((item, index) => {
                    return <tr key={index}>
                        <td>{item.ordDate.substring(0, 10)}</td>
                        {accumulationCheck(item)}
                        <td>{item.ordNo.toLocaleString()}</td>
                        <td>{item.point.toLocaleString()} P</td>
                        <td className="desc">{item.comment ? item.comment : item.ordNo + '번 주문에 사용'}</td>
                        <td>{item.pointDate ? item.pointDate.substring(0, 10):'-'}</td>
                    </tr>
                })}
            </tbody>
        </table>
    </article>
}

export default Point;