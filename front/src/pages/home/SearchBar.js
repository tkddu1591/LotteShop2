import {useDispatch} from "react-redux";
import {Link, useNavigate} from "react-router-dom";
import {useState} from "react";
import {changeCategoryNo, changeCateNames} from "../../slice/cateSilce";

function SearchBar() {
    let dispatch = useDispatch();
    let navigate = useNavigate();
    let [search, setSearch] = useState('');
    return<>
        <div className="logo">
            <div>
                <Link to={process.env.PUBLIC_URL + "/"}><img
                    src={`${process.env.REACT_APP_HOME_URL}/images/header_logo.png`} alt="로고"/></Link>
                <div>
                    <input
                        onChange={(e) => {
                            setSearch(e.target.value)
                        }}
                        onKeyUp={(e) => {
                            if (e.keyCode === 13) {
                                dispatch(changeCateNames(''))
                                dispatch(changeCategoryNo(0))
                                navigate(process.env.PUBLIC_URL + "/product/list?search=" + search)
                            }
                        }}


                    />
                    <button><i className="fa fa-search"
                               onClick={(e) => {
                                   navigate(process.env.PUBLIC_URL + "/product/list?search=" + search)
                               }}
                    ></i></button>
                </div>
            </div>
        </div>
    </>
}
export default SearchBar;