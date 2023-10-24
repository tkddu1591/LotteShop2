import {HOME_URL} from "../../App";

function MyNav({setDivName, divName, userData}) {

    return <>
        <nav>
            <div>
                <a onClick={()=>{setDivName('home')}}><img src={`${process.env.REACT_APP_HOME_URL}/images/my/my_logo.jpg`}
                                                       alt="나의쇼핑정보"/></a>
                <ol>
                    {userData.order && <li><a onClick={()=>{setDivName('order')}}>주문·배송<span className="delivery">{userData.order}</span></a></li>}
                    {userData.coupon && <li><a onClick={()=>{setDivName('coupon')}}>할인쿠폰<span className="coupon">{userData.coupon}</span></a></li>}
                    {userData.point && <li><a onClick={()=>{setDivName('point')}}>포인트<span className="point">{userData.point.toLocaleString()}</span></a></li>}
                    {userData.qna && <li><a onClick={()=>{setDivName('qna')}}>문의내역<span className="qna">{userData.qna}</span></a></li>}
                </ol>
            </div>
        </nav>
    </>
}

export default MyNav;