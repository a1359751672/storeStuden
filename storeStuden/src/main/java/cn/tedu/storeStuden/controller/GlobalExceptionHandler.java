package cn.tedu.storeStuden.controller;

import cn.tedu.storeStuden.controller.ex.FileEmptyException;
import cn.tedu.storeStuden.controller.ex.FileSizeException;
import cn.tedu.storeStuden.controller.ex.FileTypeException;
import cn.tedu.storeStuden.controller.ex.FileUploadException;
import cn.tedu.storeStuden.entity.JsonResult;
import cn.tedu.storeStuden.service.ex.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//用于封装统一异常处理逻辑
@ControllerAdvice
public class GlobalExceptionHandler {
//    统一处理业务层抛出的异常
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public JsonResult<Void> handeCustomException(Throwable e){
        JsonResult<Void> jr = new JsonResult<>();
//        添加异常提示信息
        jr.setMsg(e.getMessage());
//        添加异常状态码
        if (e instanceof UpdateException){
            jr.setState(2001);
        }else if (e instanceof UserExistException){
            jr.setState(2002);
        }else if (e instanceof InsertException){
            jr.setState(3000);
        }else if (e instanceof LoginException){
          jr.setState(3001);
        }
        else if (e instanceof UpdateException){
            jr.setState(4000);
        }
        else if (e instanceof AddressCountLimitException){
            jr.setState(2003);
        }else {
            jr.setState(2000);
        }
        return jr;
    }

//    统一处理控制层抛出的异常
    @ExceptionHandler(FileUploadException.class)
    @ResponseBody
    public JsonResult<Void> handleFileUploadException(Throwable e){
        JsonResult<Void> jr = new JsonResult<>();
//        添加异常信息
        jr.setMsg(e.getMessage());
//        添加异常状态码
        if (e instanceof FileTypeException){
            jr.setState(6001);
        }else if (e instanceof FileSizeException){
            jr.setState(6002);
        } else if (e instanceof FileEmptyException) {
            jr.setState(6003);
        } else {
            jr.setState(6000);
        }
        return jr;
    }
}
