import React, { useContext } from "react";
import { NavLink, useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";
import { toast } from "react-toastify";
import { useLoginMutation } from "../store/services/userServices";
import { useDispatch } from "react-redux";
import { setUser } from "../store/slices/appSlices";
// import { GlobalContext } from "../context/global/GlobalState";
// import { LOGIN } from "../context/global/globalReducer";

function Login() {
  // const { dispatch } = useContext(GlobalContext);
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const [login] = useLoginMutation();
  const submitHandler = async (data) => {
    login(data)
      .unwrap()
      .then((response) => {
        console.log(response);
        navigate("/");
        toast.success("Signed up");
        dispatch(setUser(response));
        localStorage.setItem("user", JSON.stringify(response));
      });
  };

  return (
    <div className="flex h-screen min-h-full flex-col overflow-hidden justify-center px-6 py-12 lg:px-8 bg-gradient-to-r from-blue-500 to-purple-600">
      <div className="sm:mx-auto sm:w-full sm:max-w-sm">
        {/* <img
          className="mx-auto h-20 w-auto"
          src="https://tailwindui.com/img/logos/mark.svg?color=indigo&shade=600"
        /> */}
        <p className="mt-10 text-center text-[30px] font-extrabold text-white">
          Tizimga kirish
        </p>
      </div>

      <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm bg-white p-8 rounded-lg shadow-lg">
        <form onSubmit={handleSubmit(submitHandler)} className="space-y-6">
          <div>
            <label
              htmlFor="email"
              className="block text-sm font-medium text-gray-700"
            >
              Email
            </label>
            <div className="mt-2">
              <input
                {...register("username", {
                  required: "username to'ldiring",
                  pattern: {
                    value: /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/i,
                    message: " emailga mos bo'lmagan format",
                  },
                })}
                type="text"
                autoComplete="email"
                className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              />
              {errors.email && (
                <p className="mt-2 text-sm text-red-600">
                  {errors.email.message}
                </p>
              )}
            </div>
          </div>

          <div>
            <div className="flex items-center justify-between">
              <label
                htmlFor="password"
                className="block text-sm font-medium text-gray-700"
              >
                Parol
              </label>
              <div className="text-sm"></div>
            </div>
            <div className="mt-2">
              <input
                {...register("password", {
                  required: "Porol bo'sh",
                  minLength: {
                    value: 6,
                    message: "porol 6 raqamdan kam bo'lmasin",
                  },
                })}
                type="password"
                autoComplete="current-password"
                className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              />
              {errors.password && (
                <p className="mt-2 text-sm text-red-600">
                  {errors.password.message}
                </p>
              )}
            </div>
          </div>

          <div>
            <button
              type="submit"
              className="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-600"
            >
              Kirish
            </button>
            <NavLink
              className="mt-2 flex w-full justify-center rounded-md bg-green-600 px-3 py-1.5 text-sm font-semibold text-white shadow-sm hover:bg-green-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-green-600"
              to={"/register"}
            >
              Ro'yxatdan o'tish
            </NavLink>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;
