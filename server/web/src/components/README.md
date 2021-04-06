# Components Directory
## Reference
You should listen [here](https://vueschool.io/articles/vuejs-tutorials/structuring-vue-components/) on Vue School.  

## Structure
### ui
> There is another split point on UI components: those that are reusable across the whole app. They communicate just by using props and events, not holding any application logics.

example
- `Button`
- `List`

### components.layout
> The AppFooter and AppHeader components, however, are not exactly UI components. Instead they're more like components.layout components since the app will have only one footer and header. You don't need to, but you can move them to a components.layout folder if you want:

example
- `Header`
- `Footer`

### *domain component*
> What about the ArticleList component? We can have components that are reusable in different pages, so we shouldn't place them with the page components. However, they belong to a specific domain, in this case to the article domain.

> Let's call them domain components. A good way to organize them is to place them in separate folders under components, one folder per domain:

### common
> We can place this kind of uncategorised common components under a common folder:
