<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</head>

<body class="d-flex flex-column justify-content-between vh-100">
    <header>
        <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">게임 사이트</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/lotto/list.do">로또</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/rsp/rsp_game">가위바위보</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="${pageContext.request.contextPath}/board/list.do">게시판</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </header>
    <main>
        <div class="container">
            <!-- Page Heading -->
            <h1 class="h3 m-3 text-gray-800 text-center">자유 게시판</h1>        
            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3 text-center">
                    <h6 class="m-0 font-weight-bold text-primary">해당 게시판에서는 자유롭게 글을 작성하실 수 있습니다. 그러나 규칙에 어긋날 경우 삭제될 수 있습니다.</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered text-center align-middle" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>                                      
                                    <th>No.</th>
                                    <th>Title</th>
                                    <th>Name</th>
                                    <th>Write date</th>
                                    <th>Hit</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>No.</th>
                                    <th>Title</th>
                                    <th>Name</th>
                                    <th>Write date</th>
                                    <th>Hit</th>
                                    <th>Delete</th>
                                </tr>
                            </tfoot>
                            <tbody >
                               <c:forEach var="board" items="${boards}">
                               	<tr>
	                            	<td>${board.bid}</td>
	                               	<td class="mx-5">
		                                <c:forEach begin="1" end="${board.bindent}">
		                                    [Re]
		                                </c:forEach>
		                                <a href="${pageContext.request.contextPath}/board/update_view.do?bid=${board.bid}" class="text-decoration-none text-dark">${board.btitle}</a>
	                             	</td>
                                  	<td>${board.bname}</td>										
                                  	<td>${board.listbdate}</td>
                                  	<td>${board.bhit}</td>
                                  	<td>
                                  		<form action="${pageContext.request.contextPath}/board/delete.do" method="post">
                                  			<input type="hidden" name="bid" value="${board.bid}">
                                  			<input type="submit" class="btn btn-success" value="삭제">
                                  		</form>
                                  	</td>                                 
	                            </tr>
                               </c:forEach>
                            </tbody>
                        </table>
                        <div class="">
	                        <nav aria-label="Page navigation example">
								<ul class="pagination justify-content-center">
									<li class="page-item disabled"><a class="page-link">Previous</a></li>
									<li class="page-item"><a class="page-link" href="#">1</a></li>
									<li class="page-item"><a class="page-link" href="#">2</a></li>
									<li class="page-item"><a class="page-link" href="#">3</a></li>
									<li class="page-item"><a class="page-link" href="#">Next</a></li>
								</ul>
							</nav>
						</div>
                    </div>
                </div>
                <div class="card-footer text-center py-2">
                	<a class="mx-1 btn btn-success">글쓰기</a>
                </div>
            </div>
        </div>
    </main>
    <footer class="text-center">
        <hr>
        <p>© Company 2022-2023</p>
    </footer>
</body>

</html>