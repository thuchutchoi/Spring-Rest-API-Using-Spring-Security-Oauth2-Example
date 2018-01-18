<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="row">
	<div class="col-xs-4 col-xs-offset-4">
		<div class="panel panel-default panel-login">
			<div class="panel-body">
				<div class="form">
					<c:url var="loginUrl" value="/login" />
					<form id="login-form" action="${loginUrl}" method="post" novalidate>
						<c:if test="${param.fail != null}">
							<div class="alert alert-danger">
								<p>
									<spring:message code="login.invalid" />
								</p>
							</div>
						</c:if>
						<c:if test="${param.permission != null}">
							<div class="alert alert-danger">
								<p>
									<spring:message code="login.permission" />
								</p>
							</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert alert-success">
								<p>
									<spring:message code="login.logout" />
								</p>
							</div>
						</c:if>
						<div class="form-group label-floating">
							<label for="username" class="control-label">ユーザーＩＤ </label> <input
								type="text" class="form-control" id="username" name="username"
								required />
								<span class="help-block">ユーザーＩＤを入力してください。</span>
						</div>
						<div class="form-group label-floating">
							<label for="password" class="control-label">パスワード</label> <input
								type="password" class="form-control" id="password"
								name="password" required />
							<span class="help-block">パスワードを入力してください。</span>
						</div>
						<%-- <input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> --%>
						<div class="form-group mb-0 p-0">
							<input id="btn-submit" type="submit"
								class="btn btn-primary btn-raised btn-block btn-lg m-0"
								value="ログイン">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>