import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { useGetRegionStatQuery } from "../store/services/globalServices";
import { setRegionStat } from "../store/slices/appSlices";

const Country = () => {
  const { regionStat } = useSelector((state) => state.app);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const {
    data: queryData,
    isSuccess: queryIssuccesss,
    isLoading,
    refetch,
  } = useGetRegionStatQuery();

  useEffect(() => {
    if (queryIssuccesss) {
      dispatch(setRegionStat(queryData));
    }
  }, [queryIssuccesss]);

  return (
    <div className="p-4">
      <div className="overflow-x-auto">
        <h1 className="text-center text-5xl border-b p-5">
          Viloyatlar kesimida
        </h1>
        <table className="min-w-full table-auto">
          <tbody className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
            {regionStat?.map((data, index) => (
              <tr
                key={index}
                className="flex border group items-center flex-col"
              >
                <td className="flex">
                  <div className="px-4 text-xl font-bold py-2 text-center group-hover:text-blue-600">
                    {data.inactiveEntityCount}
                  </div>
                  <div className="px-4 text-xl font-bold py-2 text-center group-hover:text-green-600">
                    {data.entityCount}
                  </div>
                </td>
                <td className="px-4 py-2">{data.regionName}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Country;
