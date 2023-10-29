import {useNavigate} from "react-router-dom";
import axios from "axios";
import React from "react";
import PopReceive from "./PopReceive";
import ReviewWrite2 from "./ReviewWrite2";
import SellerData from "./SellerData";
import QnaPopup from "./QnaPopup";

function OrderList({
                       pageResponseDTO,
                       setPopup,
                       setOrderItem,
                       orderItem,
                       popup,
                       member
                   }) {
    let navigate = useNavigate();

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


    function confirmApply(value) {
        if (value === 3) {
            return
        }
    }


    return <>
        <table border="0">
            <tbody>
                <tr>
                    <th>날짜</th>
                    <th>상품정보</th>
                    <th>상태</th>
                    <th>확인/신청</th>
                </tr>
                {Array.isArray(pageResponseDTO.orderItemDTOS) && pageResponseDTO.orderItemDTOS.map((item, index) => {

                    return <tr key={item.orderItemId}>
                        <td className="date">{item.ordDate.substring(0, 10)}</td>
                        <td>
                            <a onClick={() => {
                                setPopup('orderItemDetail')
                                setOrderItem(item)
                            }} className="thumb"><img
                                src="https://via.placeholder.com/80x80"
                                alt={item.thumb1}/></a>
                            <ul>
                                <li className="company" style={{cursor: 'pointer'}} onClick={() => {
                                    setPopup('seller')
                                    setOrderItem(item)
                                }}>{item.company}</li>
                                <li className="prodName"><a onClick={() => {
                                    setPopup('orderItemDetail')
                                    setOrderItem(item)
                                }}>{item.prodName}</a></li>
                                <li>수량 : <span className="prodCount">{item.count}</span>개 / 주문번호 : <span
                                    className="ordNo">{item.ordNo}</span></li>
                                <li className="prodPrice">{(item.price - (item.price * item.discount) / 100).toLocaleString()}</li>
                            </ul>
                        </td>
                        {orderComplete(item.ordComplete)}
                        <td className="confirm">

                            {(item.ordComplete === 5) ? <>
                                    <a onClick={() => {
                                        setOrderItem(item)
                                        setPopup('review')
                                    }} className="review">상품평</a>
                                    <a className="exchange">재주문</a>
                                </> :
                                item.ordComplete !== 3 && <>
                                    {item.ordComplete !== 5 && item.ordComplete !== 2 &&
                                        <a className="receive" onClick={() => {
                                            /* eslint-disable no-restricted-globals */
                                            setPopup('receive')
                                            setOrderItem(item)
                                        }}>수취확인</a>}
                                    <a className="refund" onClick={() => {
                                        setOrderItem(item)
                                        setPopup('qna')
                                    }}>문의하기</a>
                                </>
                            }
                        </td>

                    </tr>

                })}

            </tbody>
        </table>

        {popup === 'review' &&
            <ReviewWrite2 setPopup={setPopup} item={orderItem}></ReviewWrite2>}
        {popup === 'receive' && <PopReceive setPopup={setPopup} item={orderItem}></PopReceive>}
        {popup === 'seller' && <SellerData setPopup={setPopup} item={orderItem}></SellerData>}
        {popup === 'qna' && <QnaPopup setPopup={setPopup} item={orderItem} member={member}></QnaPopup>}
        {popup === 'orderItemDetail' &&
            <OrderItemDetail setPopup={setPopup} item={orderItem} member={member}></OrderItemDetail>}
    </>

}

function OrderItemDetail({setPopup, item}) {

    const handleMaskText = (item) => {
        // Assuming you want to mask from the 4th character onward with asterisks
        const maskedText = item.toString().substring(0, 3) + '*'.repeat(item.length - 3);
        return (maskedText);
    }
    console.log(item)
    return <>
        <div id="popOrder" className="popup">
            <div>
                <nav>
                    <h1>주문상세</h1>
                    <button className="btnClose" onClick={(e) => {
                        setPopup('')
                    }}>X
                    </button>
                </nav>
                <section>
                    <article className="order">
                        <h3>주문정보</h3>
                        <table border="0">
                            <tbody>
                                <tr>
                                    <th>날짜</th>
                                    <th>상품정보</th>
                                    <th>결제금액</th>
                                    <th>상태</th>
                                </tr>
                                <tr>
                                    <td>
                                        <p className="date">{item.ordDate.substring(0, 10)}</p>
                                        주문번호 : <span className="ordNo">{item.ordNo}</span>
                                    </td>
                                    <td>
                                        <img src="https://via.placeholder.com/80x80" alt=""/>
                                        <ul>
                                            <li className="company">{item.company}</li>
                                            <li className="prodName">{item.prodName}</li>
                                            <li>수량 : <span className="prodCount">{item.count}</span>개</li>
                                            <li className="prodPrice">{(item.price - item.discount * item.price / 100).toLocaleString()} 원</li>
                                        </ul>
                                    </td>
                                    <td className="payment">
                                        <ol>
                                            <li className="price">
                                                <span>판매가</span>
                                                <span>{item.price.toLocaleString()}</span>
                                            </li>
                                            <li className="discount">
                                                <span>할인</span>
                                                <span>- {(item.discount * item.price / 100).toLocaleString()}</span>
                                            </li>
                                            <li className="total">
                                                <span>결제금액</span>
                                                <span>{(item.price - item.discount * item.price / 100).toLocaleString()}</span>
                                            </li>
                                        </ol>
                                    </td>
                                    <td className="status">배송완료</td>
                                </tr>
                            </tbody>
                        </table>
                    </article>
                    <article className="delivery">
                        <h3>배송정보</h3>
                        <table border="0">
                            <tbody>
                                <tr>
                                    <th>주문자</th>
                                    <td className="name">{item.recipName}</td>
                                </tr>
                                <tr>
                                    <th>연락처</th>
                                    <td className="hp">{item.recipHp}</td>
                                </tr>
                                <tr>
                                    <th>배송지</th>
                                    <td className="address">[{handleMaskText(item.recipZip)}] {item.recipAddr1} {item.recipAddr2}</td>
                                </tr>
                                <tr>
                                    <th>배송요청사항</th>
                                    <td className="request">{item.recipComment ? item.recipComment : '없음'}</td>
                                </tr>
                            </tbody>
                        </table>
                    </article>
                </section>
            </div>
        </div>
    </>

}

export default OrderList