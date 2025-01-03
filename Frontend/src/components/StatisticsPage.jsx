import React, { useEffect } from "react";
import { useGetGlobalStatQuery } from "../store/services/globalServices";
import { setStatistic } from "../store/slices/appSlices";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";

const StatisticsPage = () => {
  const { data, isSuccess, isLoading, refetch } = useGetGlobalStatQuery();
  const { statistic } = useSelector((state) => state.app);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  useEffect(() => {
    if (isSuccess) {
      dispatch(setStatistic(data));
      console.log(statistic);
    }
  }, [isSuccess]);
  const [foundCount, documentCount, inactiveEntityCount] = statistic[0]
    ? statistic[0]
    : [];

  const statistics = [
    { id: 1, count: foundCount, label: "Topilmalar", icon: "📦" },
    { id: 2, count: documentCount, label: "Yo'qotilgan ashyolar", icon: "🔍" },
    { id: 3, count: 0, label: "Auksionga chiqarilgan", icon: "✅" },
    {
      id: 4,
      count: inactiveEntityCount,
      label: "Egasiga topshirilganlar",
      icon: "🌐",
    },
  ];
  return (
    <div className="min-h-screen bg-gray-100 py-12 px-4">
      <div className="max-w-7xl mx-auto">
        <h1 className="text-3xl font-bold text-center mb-8">Statistika</h1>
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-6">
          {statistics.map((stat) => (
            <div
              key={stat.id}
              className="bg-white rounded-lg shadow-md flex flex-col items-center p-6"
            >
              <div className="text-4xl  text-blue-500 mb-4">{stat.icon}</div>
              <div className="text-2xl font-bold text-blue-500">
                {stat.count}
              </div>
              <div className="text-gray-600 mt-2">{stat.label}</div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default StatisticsPage;
