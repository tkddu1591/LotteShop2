import MyPageNavigation from "../MyPageNavigation";
import React from "react";

function MyCoupon({pageResponseDTO, userData, setPageRequestDTO}){
    function couponState(value){
        let today = new Date()
        console.log(today)
        let year = today.getFullYear(); // 년도
        let month = today.getMonth() + 1;  // 월
        let date = today.getDate();  // 날짜
        today = year*10000+ month*100+ date

        let endDate = parseInt(value.wdate.substring(0,4)) * 10000 + parseInt(value.wdate.substring(5,7)) *100 + parseInt(value.wdate.substring(8,10))
        console.log(endDate)
        if(value.state===1){
            return <td className="status" style={{color:'green'}}>사용완료</td>
        }else if(today> endDate){
            return <td className="status" style={{color:'red'}}>기간만료</td>
        }else
            return <td className="status">사용가능</td>
    }
    return<>
        <article>
            <h3>쿠폰</h3>
            <p>고객님께서 보유하고 있는 할인쿠폰을 확인하세요! 상품구매 시 더욱 저렴하게 구매할 수 있습니다.</p>

            <div className="bg">
                <dl>
                    <dt>· 나의 보유쿠폰</dt>
                    <dd>
                        <strong>{userData.coupon}</strong>
                        <span>장</span>
                    </dd>
                </dl>
            </div>

            <table border="0" key="myCoupon">
                <tbody>
                    <tr>
                        <th>쿠폰명</th>
                        <th>할인금액</th>
                        <th>적용기준/제한조건</th>
                        <th>유효기간</th>
                        <th>상태</th>
                    </tr>
                    {Array.isArray(pageResponseDTO.couponDTOS)&&pageResponseDTO.couponDTOS.map((item, index) => {
                        return <>
                            <tr>
                                <td className="tit">{item.cname}</td>
                                <td className="discount"><span>{item.discount.toLocaleString()}</span>원</td>
                                <td className="condition"><span>{item.termsOfUse.toLocaleString()}</span>원 이상 구매시</td>
                                <td className="expire">~{item.wdate.substring(2,4)}/{item.wdate.substring(5,7)}/{item.wdate.substring(8,10)}</td>
                                {couponState(item)}
                                {/*<td className="status" style={{color:'red'}}>사용완료</td>*/}
                            </tr>
                        </>
                    })}

                </tbody>
            </table>
            <MyPageNavigation pageResponseDTO={pageResponseDTO} setPageRequestDTO={setPageRequestDTO}></MyPageNavigation>
            <ul className="info">
                <li>순금/골드바/돌반지/상품권 등 환금성 카테고리 및 중고상품 및 일부 프로모션 상품에는 쿠폰사용이 제한됩니다.</li>
                <li>쿠폰 적용 가능한 금액기준은 판매자 상품별할인과 G마켓 추가할인이 모두 포함된 할인적용가입니다.</li>
                <li>중복쿠폰은 판매자 할인, G마켓 할인과 중복 적용 가능하며 하나의 상품당 한장의 중복쿠폰만 사용 가능합니다.</li>
                <li>항공 할인은 항공권 전용 할인으로 결제시점에 할인 혜택을 받을 수 있습니다.</li>
                <li>항공권 예약취소 또는 환불시 적용했던 항공할인은 id당 1회 한하여 다시 발급됩니다.</li>
            </ul>
        </article></>
}
export default MyCoupon