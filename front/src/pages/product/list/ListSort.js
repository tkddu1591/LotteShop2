function ListSort({changePageRequest, pageRequestDTO}) {


    return <>
        <ul className="sort">
            <li>
                <a onClick={() => changePageRequest('type', 'sold')}
                   style={{cursor: 'pointer', userSelect: 'none'}}
                   className={pageRequestDTO.type === 'sold' ? 'on' : ''}>판매많은순</a></li>
            <li>
                <a onClick={() => changePageRequest('type', 'price')}
                   style={{cursor: 'pointer', userSelect: 'none'}}
                   className={pageRequestDTO.type === 'price' ? 'on' : ''}>낮은가격순</a></li>
            <li>
                <a onClick={() => changePageRequest('type', 'priceAsc')}
                   style={{cursor: 'pointer', userSelect: 'none'}}
                   className={pageRequestDTO.type === 'priceAsc' ? 'on' : ''}>높은가격순</a></li>
            <li>
                <a onClick={() => changePageRequest('type', 'score')}
                   style={{cursor: 'pointer', userSelect: 'none'}}
                   className={pageRequestDTO.type === 'score' ? 'on' : ''}>평점높은순</a></li>
            <li>
                <a onClick={() => changePageRequest('type', 'review')}
                   style={{cursor: 'pointer', userSelect: 'none'}}
                   className={pageRequestDTO.type === 'review' ? 'on' : ''}>후기많은순</a></li>
            <li>
                <a onClick={() => changePageRequest('type', 'rdate')}
                   style={{cursor: 'pointer', userSelect: 'none'}}
                   className={pageRequestDTO.type === 'rdate' ? 'on' : ''}>최근등록순</a></li>
        </ul>
    </>
}

export default ListSort