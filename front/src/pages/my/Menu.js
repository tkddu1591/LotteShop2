import React from "react";


function Menu({setDivName, divName}) {
    return <>

        <ul>
            <span className="menu_else"></span>
            <li className={divName==='order'?"on": ''} ><a onClick={()=>{setDivName('order')}}>전체주문내역</a></li>
            <li className={divName==='point'?"on": ''}><a onClick={()=>{setDivName('point')}}>포인트내역</a></li>
            <li className={divName==='coupon'?"on": ''}><a onClick={()=>{setDivName('coupon')}}>쿠폰</a></li>
            <li className={divName==='review'?"on": ''}><a onClick={()=>{setDivName('review')}}>나의리뷰</a></li>
            <li className={divName==='qna'?"on": ''}><a onClick={()=>{setDivName('qna')}}>문의하기</a></li>
            <li className={divName==='info'?"on": ''}><a onClick={()=>{setDivName('info')}}>나의설정</a></li>
        </ul>
    </>
}

export default Menu;