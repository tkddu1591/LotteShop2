import React, {useState} from "react";
import {Link} from "react-router-dom";
import axios from "axios";
import ReviewWrite from "../ReviewWrite";
import ReviewWrite2 from "../order/ReviewWrite2";

function Latest({userOrder, setDivName, setOrderItem, setReviewWrite, orderItem, reviewWrite}) {


    function orderComplete(value) {
        if (value === 4)
            return <td className="status" style={{color: 'green'}}>배송완료</td>
        else if (value === 5)
            return <td className="status" style={{color: 'green'}}>수취확인</td>
        else if (value === 1)
            return <td className="status">배송중</td>
        else if (value === 2)
            return <td className="status" style={{color: 'red'}}>결제대기</td>

        else
            return <td className="status" style={{color: 'red'}}>주문취소</td>
    }

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
                                <Link to={`${process.env.REACT_APP_HOME_URL}/product/view?prodNo=` + item.prodNo}
                                      className="thumb">
                                    <img src="https://via.placeholder.com/80x80"
                                         alt=""/></Link>
                                <ul>
                                    <li className="company"><Link
                                        to={`${process.env.REACT_APP_HOME_URL}/product/view?prodNo=` + item.prodNo}>{item.company}</Link>
                                    </li>
                                    <li className="prodName"><Link
                                        to={`${process.env.REACT_APP_HOME_URL}/product/view?prodNo=` + item.prodNo}>{item.prodName}</Link>
                                    </li>
                                    <li className="orderNo">수량 : <span
                                        className="prodCount">{item.count}</span>개 /
                                        주문번호
                                        : <a href="#">{item.ordNo.toLocaleString()}</a></li>
                                    <li className="prodPrice">{item.price.toLocaleString()}</li>
                                </ul>
                            </td>
                            {orderComplete(item.ordComplete)}
                            <td className="confirm">

                                {item.ordComplete === 4 ? <>
                                        <a onClick={() => {
                                            setOrderItem(item)
                                            setReviewWrite(true)
                                        }} className="review">상품평</a>
                                        <a className="refund">반품신청</a>
                                        <a className="exchange">교환신청</a>
                                        <a className="exchange">재주문</a>
                                    </> :
                                    item.ordComplete !== 3 && <>
                                        <a className="receive">수취확인</a>
                                        <a className="exchange" onClick={() => {
                                            /* eslint-disable no-restricted-globals */
                                            if (confirm('주문을 취소하시겠습니까?')) {
                                                axios.delete(`${process.env.REACT_APP_API_ROOT}/product/order/delete`, {
                                                    params: {ordNo: item.ordNo}
                                                }).then(
                                                    res => {
                                                        alert('주문이 취소되었습니다.')
                                                    }
                                                ).catch(err => {
                                                    console.log(err)
                                                })
                                            }
                                        }}>주문취소</a>
                                    </>
                                }
                            </td>
                            {orderItem.ordComplete === 4 && reviewWrite&&
                                <ReviewWrite2 setReviewWrite={setReviewWrite} item={orderItem}></ReviewWrite2>}

                        </tr>
                    })}

                </tbody>
            </table>
        </article>
    </>
}

export default Latest;