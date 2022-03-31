package com.lebooks.service.back;

import com.lebooks.dao.AdminDao;
import com.lebooks.dao.ArticleDao;
import com.lebooks.dao.OrderDao;
import com.lebooks.dao.UserDao;
import com.lebooks.entity.Admin;
import com.lebooks.entity.Article;
import com.lebooks.entity.Order;
import com.lebooks.entity.User;
import com.lebooks.util.pager.PagerModel;

import java.util.List;

public class ManageService {
    private UserDao userDao = new UserDao();
    private ArticleDao articleDao = new ArticleDao();
    private OrderDao orderDao = new OrderDao();
    private AdminDao adminDao = new AdminDao();
    public List<User> getAllUser(PagerModel pagerModel) {
        // 查询总记录数
        int totalNum  = userDao.getTotalNum();
        pagerModel.setTotalNum(totalNum);
        return userDao.getAllUser(pagerModel);
    }

    public List<User> getRequUser(String select_type, String keyword, PagerModel pagerModel) {
        int totalNum = userDao.getRequTotalNum(select_type,keyword);
        pagerModel.setTotalNum(totalNum);
        return userDao.getRequUser(select_type,keyword);
    }

    public List<Article> getRequArticle(String select_type, String keyword) {
        keyword = keyword == null ? "%%" :"%" + keyword +"%";
        List<Article> articles = articleDao.getRequArticle(select_type,keyword);
        return articles;
    }

    public List<Article> getAllArticle(PagerModel pagerModel) {
        // 查询总记录数
        int totalNum = articleDao.getTotalNum(null);
        pagerModel.setTotalNum(totalNum);
        List<Article> articles = articleDao.getAllArticle(pagerModel);
        return articles;
    }

    public boolean deleteBook(int book_id) {
        return articleDao.deleteBook(book_id);
    }

    public boolean editBookInfo(Article article) {
        return articleDao.editBookInfo(article);
    }

    public List<Order> getRequOrder(String select_type, String keyword, PagerModel pagerModel) {
        int totalNum = orderDao.getRequTotalNum(select_type,keyword);
        pagerModel.setTotalNum(totalNum);
        keyword = keyword == null ? "%%" :"%" + keyword +"%";
        return orderDao.getRequOrder(select_type,keyword);
    }

    public List<Order> getAllOrder(PagerModel pagerModel) {
        // 查询总记录数
        int totalNum = orderDao.getTotalNum();
        pagerModel.setTotalNum(totalNum);
        return orderDao.getAllOrder(pagerModel);
    }

    public List<Admin> getRequAdmin(String select_type, String keyword) {
        keyword = keyword == null ? "%%" :"%" + keyword +"%";
        return adminDao.getRequAdmin(select_type,keyword);
    }

    public List<Admin> getAllAdmin(PagerModel pagerModel) {
        // 查询总记录数
        int totalNum  = adminDao.getTotalNum();
        pagerModel.setTotalNum(totalNum);
        return adminDao.getALLAdmin(pagerModel);
    }

    public boolean deleteAdmin(int admin_id) {
        return adminDao.deleteAdmin(admin_id);
    }

    public Admin getAdminById(int admin_id) {
        return adminDao.getAdminById(admin_id);
    }
}
