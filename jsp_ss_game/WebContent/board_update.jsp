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
        <div class="container w-50 mx-auto">
            <!-- Page Heading -->
            <h1 class="h3 m-5 text-gray-800 text-center">게시글 수정</h1>        
            <!-- DataTales Example -->
            <div class="card shadow mb-4">
            	<form action="${pageContext.request.contextPath}/board/update.do" method="post" >
               		<div class="card-header py-3 text-center">
	                   <h6 class="m-0 font-weight-bold text-primary">선택한 게시글을 수정하거나 취소하실 수 있습니다.</h6>
	                </div>
	                <div class="card-body p-5">
	                   <p class="my-2"> Type </p> 
	                   <p class="my-2"><input class="w-100 bg-success text-white rounded border-dark-subtle" type="text" value="자유 게시판" readonly="readonly"></p>
	                   <p class="my-2">BoardID</p>
	                   <p class="my-2"><input class="w-100 bg-secondary text-white rounded border-dark-subtle" type="text" name="bid" value="${board.bid}" readonly="readonly"></p>
	                   <p class="my-2">이름</p>
	                   <p class="my-2"><input class="w-100 rounded" type="text" name="bname" value="${board.bname}" ></p>
	                   <p class="my-2">제목</p>
	                   <p class="my-2"><input class="w-100 rounded" type="text" name="btitle" value="${board.btitle}" ></p>
	                   <p class="my-2 text-left">내용</p>
	                   <textarea name="bcontent" class="w-100 rounded" rows="6" cols="5">${board.bcontent}</textarea>
	                </div>
	                <div class="card-footer text-center py-2 d-flex justify-content-between">
	                	<input type="submit" class="mx-1 btn btn-success" value="Update">
	                	<a href="${pageContext.request.contextPath}/board/list.do" class="mx-1 btn btn-danger" >Cancel</a>
	                </div>
                </form>
            </div>
        </div>
    </main>
    <footer class="text-center">
        <hr>
        <p>© Company 2022-2023</p>
    </footer>
</body>

</html>