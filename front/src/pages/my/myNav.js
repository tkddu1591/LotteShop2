import {HOME_URL} from "../../App";

function MyNav({setDivName, divName, userData}) {

    return <>
        <nav>
            <div>
                <a onClick={()=>{setDivName('home')}}><img src={`${process.env.REACT_APP_HOME_URL}/images/my/my_logo.jpg`}
                                                       alt="나의쇼핑정보"/></a>
                <ol>
                    <li><a onClick={()=>{setDivName('order')}}>주문·배송<span className="delivery">{userData.order !==0? userData.order : '-'}</span></a></li>
                    <li><a onClick={()=>{setDivName('coupon')}}>할인쿠폰<span className="coupon">{userData.coupon !==0? userData.coupon : '-'}</span></a></li>
                    <li><a onClick={()=>{setDivName('point')}}>포인트<span className="point">{userData.point !==0 && userData.point? userData.point.toLocaleString() : '-'}</span></a></li>
                    <li><a onClick={()=>{setDivName('qna')}}>문의내역<span className="qna">{userData.qna !==0? userData.qna : '-'}</span></a></li>
                </ol>
            </div>
        </nav>
    </>
}

export default MyNav;