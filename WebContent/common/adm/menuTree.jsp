<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../../common/tags.jsp"%>
<%@ include file="../../common/params.jsp"%>
<div id="navigation">
	<ul>
		<li class='active'><a href='#'><span>Home</span></a></li>
		<li class='has-sub'><a href='#'><span>Products</span></a>
			<ul>
				<li><a href='#' class="sub-level2"><span>Product 1</span></a></li>
				<li class='has-sub'>
					<a href='#' class="sub-level2"><span>Product 2</span></a>
					<ul>
						<li class='last'><a href='#'><span>Product 2.1</span></a></li>
						<li class='last'><a href='#'><span>Product 2.2</span></a></li>
						<li class='last'><a href='#'><span>Product 2.3</span></a></li>
					</ul>
				</li>
				<li class='has-sub'>
					<a href='#' class="sub-level2"><span>Product 3</span></a>
					<ul>
						<li class='last'><a href='#'><span>Product 3.1</span></a></li>
						<li class='last'><a href='#'><span>Product 3.2</span></a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li class='has-sub'><a href='#' ><span>About</span></a>
			<ul>
				<li><a href='#' class="sub-level2" ><span>Company</span></a></li>
				<li class='last'><a href='#' class="sub-level2"><span>Contact</span></a></li>
			</ul>
		</li>
		<li class='last'><a href='#' ><span>Contact</span></a></li>
	</ul>
</div>