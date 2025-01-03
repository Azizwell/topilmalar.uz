import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Root from "./routes/Root.jsx";
import { Provider } from "react-redux";
import { store } from "./store/store.js";
import Login from "./routes/Login.jsx";
import Register from "./routes/Register.jsx";
import { ToastContainer } from "react-toastify";
import Navbar from "./components/Navbar.jsx";
import Apply from "./components/Apply.jsx";
import "react-toastify/dist/ReactToastify.css";
import ViewReestr from "./routes/ViewReestr.jsx";
import Reestr from "./routes/Reestr.jsx";
const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    children: [
      {
        // path: "/navbar",
        index: true,
        element: <Navbar />,
      },
      {
        path: "/apply",
        element: <Apply />,
      },
    ],
  },
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/register",
    element: <Register />,
  },
  {
    path: "/view_reestr",
    element: <ViewReestr />,
  },
  {
    path: "/reestr",
    element: <Reestr />,
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <Provider store={store}>
    <RouterProvider router={router} />
    <ToastContainer />
  </Provider>
);
