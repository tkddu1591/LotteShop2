import React from "react";


function Menu() {
    return <>

        <ul>
            <span className="menu_else"></span>
            <li className="on"><a href="#">전체주문내역</a></li>
            <li><a href="#">포인트내역</a></li>
            <li><a href="#">쿠폰</a></li>
            <li><a href="#">나의리뷰</a></li>
            <li><a href="#">문의하기</a></li>
            <li><a href="#">나의설정</a></li>
        </ul>
    </>
}

export default Menu;