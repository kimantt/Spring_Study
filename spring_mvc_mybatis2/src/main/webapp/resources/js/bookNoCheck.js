$(document).ready(function() {
	$('#bookNoCheckBtn').on('click', function(e) {
		e.preventDefault(); // submit 방지
		
		let bookNo = $('#bookNo').val();
				
		if (bookNo == "") {
			alert("도서번호를 입력하세요.");
			return false;
		}
		else { // 서버 측에 도서번호 중복 확인 요청
			$.ajax({
				type:"post",
				url:"/mybatis2/book/bookNoCheck",
				data:{"bookNo":bookNo},
				dataType:"text",
				success:function(result) {
					if (result == "available") {
						alert("사용가능한 번호입니다.");
					}
					else {
						alert("사용 불가능한 번호입니다.");
					}
				},
				error:function() {
					alert("서버 요청 실패");
				}
			});
		}
	});
});
