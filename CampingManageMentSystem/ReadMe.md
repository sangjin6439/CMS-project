예외처리 



엔티티 생성
BaseEntity(상속 추상클래스)-> 아이디, 날짜시간, 수정시 
User-> BaseEntity(상속), 이름, 전화번호
Item-> BaseEntity(상속), 이름, 가격, *총합
Order-> BaseEntity(상속), User
OrderDetail-> BaseEntity(상속), User, Item, 구매 수량(개수)

엔티티 DTO 생성
요청 받는 것, 응답 하는 것 따로 나눠서 작성
request

response 


Repository



Service



Controller



