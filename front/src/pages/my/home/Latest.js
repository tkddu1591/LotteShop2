import React, {useState} from "react";
import {Link} from "react-router-dom";

function Latest({userOrder, setDivName}) {
    let [review, setReview] = useState(false)
    return <>
        <article className="latest">
            <h3>최근주문내역</h3>
            <a onClick={() => {
                setDivName('order')
            }} className="more">더보기</a>
            <table>
                <tbody>
                    <tr>
                        <th>날짜</th>
                        <th>상품정보</th>
                        <th>상태</th>
                        <th>확인/신청</th>
                    </tr>
                    {userOrder.map((item, index) => {
                        return <tr key={`latest${index}${item.prodNo}`}>
                                <td className="date">{item.ordDate.substring(0, 10)}</td>
                                <td className="info">
                                    <Link to={`${process.env.REACT_APP_HOME_URL}/product/view?prodNo=` + item.prodNo} className="thumb">
                                        <img src="https://via.placeholder.com/80x80"
                                            alt=""/></Link>
                                    <ul>
                                        <li className="company"><Link to={`${process.env.REACT_APP_HOME_URL}/product/view?prodNo=` + item.prodNo}>{item.company}</Link></li>
                                        <li className="prodName"><Link to={`${process.env.REACT_APP_HOME_URL}/product/view?prodNo=` + item.prodNo}>{item.prodName}</Link></li>
                                        <li className="orderNo">수량 : <span
                                            className="prodCount">{item.count}</span>개 /
                                            주문번호
                                            : <a href="#">{item.ordNo.toLocaleString()}</a></li>
                                        <li className="prodPrice">{item.price.toLocaleString()}</li>
                                    </ul>
                                </td>
                                <td className="status">{item.ordComplete === 1 ? '배송완료' : item.ordComplete === 0 ? '배송중' : '주문취소'}</td>
                                <td className="confirm">
                                    <a href="#" className="receive">수취확인</a>
                                    <a href="#" className="review" onClick={() => {
                                        setReview(true)
                                    }}>상품평</a>
                                    <a href="#" className="refund">반품신청</a>
                                    <a href="#" className="exchange">교환신청</a>
                                </td>
                            </tr>
                    })}

                </tbody>
            </table>
        </article>
    </>
}

export default Latest;