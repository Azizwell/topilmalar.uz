import React, { useEffect } from "react";
import laptopImg from "../assets/laptop.png";
import mapImg from "../assets/map.png";
import phoneImg from "../assets/phone.jpg";
import {
  setIsSearch,
  setReestrData,
  setSearch,
} from "../store/slices/appSlices";
import { useDispatch, useSelector } from "react-redux";
import { useGetMyQueryQuery } from "../store/services/globalServices";
import { Outlet, useNavigate } from "react-router-dom";

const Header = () => {
  const { search, isSearch } = useSelector((state) => state.app);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const {
    data: queryData,
    isSuccess: queryIssuccesss,
    isLoading,
    refetch,
  } = useGetMyQueryQuery(search);

  useEffect(() => {
    refetch().then((res) => {
      if (isSearch) {
        dispatch(setReestrData(res.data));
        navigate("/reestr");
      }
    });
  }, [isSearch]);
  return (
    <div className="bg-white min-h-screen flex items-center">
      <div className="container mx-auto flex flex-col md:flex-row items-center h-full px-4">
        <div className="w-full md:w-2/3 mb-8 md:mb-0">
          <div className="text-center md:text-left">
            <h1 className="text-3xl md:text-4xl font-bold text-blue-600">
              Topilmalar avtomatlashtirilgan qidiruv tizimi
            </h1>
            <p className="text-blue-600 mt-4">
              Topilmalar va yo‘qolgan ashyolarning elektron reyestridan qidirish
            </p>
            <form
              onSubmit={(e) => {
                e.preventDefault();
                dispatch(setIsSearch(true));
              }}
              className="mt-6 flex justify-center md:justify-start items-center"
            >
              <input
                id="search"
                name="search_text"
                placeholder="So'rovingizni kiriting..."
                type="text"
                onChange={(e) =>
                  dispatch(
                    setSearch({ ...search, serialNumber: e.target.value })
                  )
                }
                className="w-full md:w-auto flex-1 px-4 py-2 border border-blue-600 rounded-md shadow-sm focus:ring focus:ring-blue-600"
              />
              <button
                type="submit"
                className="ml-2 px-4 py-2 bg-blue-600 text-white rounded-md shadow "
              >
                Qidiruv
              </button>
            </form>
          </div>
        </div>

        <div className="w-full md:w-1/3 relative flex justify-center md:justify-end">
          <div className="relative space-y-8">
            <div className="w-40 h-24">
              <img
                src={laptopImg}
                alt="Ноутбук"
                className="w-full h-full object-contain rounded-md shadow-lg"
              />
            </div>

            <div className="w-32 h-32">
              <img
                src={mapImg}
                alt="Карта"
                className="w-full h-full object-contain rounded-full shadow-md"
              />
            </div>

            <div className="w-20 h-40">
              <img
                src={phoneImg}
                alt="Телефон"
                className="w-full h-full object-contain rounded-md shadow-lg"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Header;
