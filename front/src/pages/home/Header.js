import {Link, useLocation, useNavigate} from "react-router-dom";
import {changeCategoryNo, changeCateNames} from "../../slice/cateSilce";
import {useDispatch} from "react-redux";
import {API_BASE_URL} from "../../App";
import LoginHeader from "./LoginHeader";
import SearchBar from "./SearchBar";

function Header() {
    let navigator = useNavigate();

    let dispatch = useDispatch();


    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);
    const newCate = searchParams.get('cate');
    const newType = searchParams.get('type');

    return (
        <header>
            <LoginHeader></LoginHeader>
            <SearchBar></SearchBar>
            <div className="menu">
                <div>
                    <ul>
                        <li><a style={{
                            fontWeight: (newCate === null ? newType === 'hit' ? 'bold' : null : null),
                            cursor: 'pointer',
                            userSelect: 'none'
                        }}
                               onClick={() => {
                                   (navigator(process.env.PUBLIC_URL + "/product/list?type=hit"))
                                   dispatch(changeCateNames(''))
                                   dispatch(changeCategoryNo(0))
                               }
                               }>히트상품</a></li>
                        <li><a style={{
                            fontWeight: (newCate === null ? newType === 'score' ? 'bold' : null : null),
                            cursor: 'pointer',
                            userSelect: 'none'
                        }}
                               onClick={() => {
                                   (navigator(process.env.PUBLIC_URL + "/product/list?type=score"))
                                   dispatch(changeCateNames(''))
                                   dispatch(changeCategoryNo(0))
                               }
                               }>추천상품</a></li>
                        <li><a style={{
                            fontWeight: (newCate === null ? newType === 'rdate' ? 'bold' : null : null),
                            cursor: 'pointer',
                            userSelect: 'none'
                        }}
                               onClick={() => {
                                   (navigator(process.env.PUBLIC_URL + "/product/list?type=rdate"))
                                   dispatch(changeCateNames(''))
                                   dispatch(changeCategoryNo(0))
                               }
                               }>최신상품</a></li>
                        <li><a style={{
                            fontWeight: (newCate === null ? newType === 'sold' ? 'bold' : null : null),
                            cursor: 'pointer',
                            userSelect: 'none'
                        }}
                               onClick={() => {
                                   (navigator(process.env.PUBLIC_URL + "/product/list?type=sold"))
                                   dispatch(changeCateNames(''))
                                   dispatch(changeCategoryNo(0))
                               }
                               }>인기상품</a></li>
                        <li><a style={{
                            fontWeight: (newCate === null ? newType === 'discount' ? 'bold' : null : null),
                            cursor: 'pointer',
                            userSelect: 'none'
                        }}
                               onClick={() => {
                                   (navigator(process.env.PUBLIC_URL + "/product/list?type=discount"))
                                   dispatch(changeCateNames(''))
                                   dispatch(changeCategoryNo(0))
                               }
                               }>할인상품</a></li>
                    </ul>
                    <ul>
                        <li><Link to={API_BASE_URL + "/cs/notice/list?cate=all"}>공지사항</Link></li>
                        <li><Link to={API_BASE_URL + "/cs/faq/list?cate=member"}>자주묻는질문</Link></li>
                        <li><Link to={API_BASE_URL + "/cs/qna/list?cate=member"}>문의하기</Link></li>
                        <li>
                            <form action={API_BASE_URL + "/index"} method="post">
                                <input type="hidden" name="memberUid" value={localStorage.getItem('memberUid')}/>
                                <input type="hidden" name="expirationTime" value={localStorage.getItem('expirationTime')}/>
                                <input type="hidden" name="token" value={localStorage.getItem('token')}/>
                                <input type="hidden" name="authority" value={localStorage.getItem('authority')}/>
                          <input type="submit" value="고객센터" style={{border:'none',   borderLeft: '1px solid #e9e9e9', padding: '0 10px', cursor:'pointer'}}></input>
</form>

                        </li>
                    </ul>
                </div>
            </div>
        </header>
    )
}

export default Header;