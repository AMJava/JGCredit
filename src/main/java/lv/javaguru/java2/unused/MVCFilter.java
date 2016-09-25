package lv.javaguru.java2.unused;

public class MVCFilter{
/*
    private static final Logger logger = Logger.getLogger(MVCFilter.class.getName());
    private Map<String, MVCController> controllers;
    private AnnotationConfigWebApplicationContext springContext;
    private MVCController getBean(Class clazz){
        return (MVCController) springContext.getBean(clazz);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            springContext = new AnnotationConfigWebApplicationContext();
            springContext.register(SpringConfig.class);
            springContext.refresh();
        } catch (BeansException e) {
        }
        controllers = new HashMap<String, MVCController>();
        controllers.put("/home", getBean(HomeController.class));
        controllers.put("/operations", getBean(OperationController.class));
        controllers.put("/about", getBean(AboutController.class));
        controllers.put("/contacts", getBean(ContactsController.class));

        controllers.put("/login", getBean(LoginController.class));
        controllers.put("/logout", getBean(LogoutController.class));
        controllers.put("/register", getBean(RegisterController.class));
        controllers.put("/restorePassword", getBean(RestorePassController.class));
        controllers.put("/changePassword", getBean(ChangePassController.class));

        controllers.put("/error", getBean(ErrorController.class));

        controllers.put("/profile", getBean(ProfileController.class));
        controllers.put("/editProfile", getBean(EditProfileController.class));
        controllers.put("/loans", getBean(LoanController.class));
        controllers.put("/loans/extend", getBean(LoanExtController.class));
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String contextURI = req.getServletPath();
        MVCModel model = null;
        MVCController controller = controllers.get(contextURI);
        if (controller != null)  {
            if (req.getMethod().equals("POST")) {
                try {
                    model = controller.executePostRequest(req);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ServiceException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    model = controller.executeGetRequest(req);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                req.setAttribute("model", model.getData());
                req.setAttribute("message", model.getMessage());
                req.setAttribute("error", model.getError());
            ServletContext context = req.getServletContext();
            RequestDispatcher requestDispacher =
            context.getRequestDispatcher(model.getViewName());
            requestDispacher.forward(req, resp);
        }
        else {
            filterChain.doFilter(request,response);
        }
    }

    public void destroy() {

    }
*/
}
