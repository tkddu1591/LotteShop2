import {API_BASE_URL, HOME_URL} from "../../App";

function MyNav({setDivName, divName, userData}){

    return <><nav>
            <div>
                <a href={`${HOME_URL}/home.html`}><img src={`${process.env.REACT_APP_HOME_URL}/images/my/my_logo.jpg`} alt="나의쇼핑정보"/></a>
                <ol>
                    <li><a href="#">주문·배송<span class="delivery">1</span></a></li>
                    <li><a href="#">할인쿠폰<span class="coupon">1</span></a></li>
                    <li><a href="#">포인트<span class="point">1,000</span></a></li>
                    <li><a href="#">문의내역<span class="qna">1</span></a></li>
                </ol>
            </div>
        </nav>
    </>
}
export default MyNav;