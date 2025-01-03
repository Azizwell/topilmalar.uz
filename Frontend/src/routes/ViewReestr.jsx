import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { setViewReestr, setViewReestrItem } from "../store/slices/appSlices";

const ViewReestr = () => {
  const { viewReestr, viewReestrItem } = useSelector((state) => state.app);
  const navigate = useNavigate();
  const dispatch = useDispatch();
  function resetField() {
    navigate("/reestr");
    dispatch(setViewReestrItem([]));
    dispatch(setViewReestr([]));
  }
  return (
    <div className="bg-gray-100 p-6 relative">
      <a onClick={() => resetField()} className="mt-5 absolute">
        <img
          src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAYAAABV7bNHAAADq0lEQVR4XuWcXW7TQBDHlyYplPLZDz5OwAm4CFKvwCtCqoR4WwlhJ4rEQ08BuUBP0Le+IIggCW0hQaWCB45g/F9qFM86jh3Wuzv2SL8X2/F6/5qZnd3uVgibFkVXhIzaYv9iU/R+3RTy9x0R/NhVvP76MAWuydGOkLMt9Sx+I4fr9JX8DaKozsUdlWcPNCFWAe96PtsQe4MWbY6HzYtCO2eaRCwWpkJoeMOYp5RBfrmn2vbSq1wKQ0mE8saQOPvxR9EPdQ2EOoiu0s+1Z8prJre0D/MNjID4Vqs2iOPcR69ZBLzJWm5CSPmQa0pzel8cTCoOuf33m3rDzJDn12m3zBhGBtoYV4yPcnXwHIoxT0Lc0pfXhf+e22G0YpmQixIn7pVHN9QOnIbyVUEJsFKdxKEINAWKyVImz65pL6k7pfJRE0KLUjjU6lTvlEX+XFIfcZtjGSce1XK9qMnek5DrRY32noRFXvRmtqE/3FAypyE2FtjzeHX6qB2MDkV48li7Z5vg03ZaHCRn+pBNlDjjD+1wFLWC0dQLkVJh5jK85sSZ40h7zjapMHMVXhnidMLxtBNO3XtQKszoTRv4LI4iGc0wB9FuVoz34lyCfQTqT8T0RpVwEQeoPGRzWYOTOEAtg9hK0NzEAeG3u0K8nOh7c0zDURyAJZDK519cxQFKIHrRJBniXHLUCSdvTdEKTp5obZtCu2CKxeIYZ607fqa1bwrtgil6sUDh6CPtTBXwFAgsEqkbh1h39M4UrV6VIVZ1ks4QyZsZ+zKsjGKAq0jyfEeoYojeqAKOIgXft+1ONbiJpKYatiernERSk9Wnxx3tRtVwEUlG63GIyTUnW1w4iPTPsLxIb9rAZ5FUgk7Mdh6aJ0Oktg+L9qnzHwgz+oBN5kTyZqa/F5GdZ67CLOGvSIdeiJMKr8RchplvZB6vcjWa+Yaafy0ybP2gP2gavc85+xWb7kXq0AtNztSa7EW53pMYvMjGEohv5OYeai7+HO2a0qcTXxzf1l5SV7DkU9qaEmqF90dn2SCq92EW9G3pqLXM6pyPjB3R7NfwQB36ZNRQI9BGuFKo3lnF6uBJxj2HGo5KcUzc+Ga1xmzDMLpxKgEKzbFMG+okDsUkisCV6xwThpDz0ZvUf4GxFVJFDCODD0Ih1+BbnHrNIkNuciWU18JkGc5/YPGbdsQ0aAPr6WyEoQavMikWPIW9KHmGxKn+AVw8uqCjwWRX9C/0kMQ1IIdb6ln8BvsILIvyB/XV/olYAwaMAAAAAElFTkSuQmCC"
          alt=""
          id="back-view"
        />
      </a>
      <div className="max-w-4xl mx-auto bg-white shadow-md rounded-lg">
        {/* Header */}
        <div className="px-6 py-4 border-b">
          <h1 className="text-xl font-bold text-gray-700">
            YO'QOTILGAN ASHYO HAQIDA MA'LUMOT
          </h1>
        </div>

        {/* Table */}
        {viewReestr.id ? (
          <div className="px-6 py-4">
            <table className="w-full text-sm text-left text-gray-700 border border-gray-300">
              <tbody>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end">
                    Ariza raqami:
                  </td>
                  <td className="py-2 px-4">{viewReestr.id}</td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Xizmat nomi:
                  </td>
                  <td className="py-2 px-4">
                    Yo'qolgan ashyoni davlat xizmatlari markazi orqali izlash
                  </td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">Turi:</td>
                  <td className="py-2 px-4">Hujjat</td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Hujjat turi:
                  </td>
                  <td className="py-2 px-4">{viewReestr?.market.name}</td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Nomi/tavsifi:
                  </td>
                  <td className="py-2 px-4"> {viewReestr?.name}</td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">Mazmuni:</td>
                  <td className="py-2 px-4">{viewReestr.docContent}</td>
                </tr>

                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Seria va raqami:
                  </td>
                  <td className="py-2 px-4">
                    {viewReestr.documentSerialNumber}
                  </td>
                </tr>

                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Ashyo egasi:
                  </td>
                  <td className="py-2 px-4">{viewReestr.snp.toUpperCase()}</td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Yo'qolgan taxminiy hudud:
                  </td>
                  <td className="py-2 px-4">
                    {viewReestr.givenRegion.name}
                    <br />
                    {viewReestr.lossDistrict.name}
                  </td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Yo'qolgan taxminiy ko'cha:
                  </td>
                  <td className="py-2 px-4"> {viewReestr.lossAddress}</td>
                </tr>

                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Reestrdagi seriyasi va raqami:
                  </td>
                  <td className="py-2 px-4">{viewReestr.serialNumber}</td>
                </tr>
              </tbody>
            </table>
          </div>
        ) : viewReestrItem.id ? (
          <div className="px-6 py-4">
            <table className="w-full text-sm text-left text-gray-700 border border-gray-300">
              <tbody>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Ariza raqami:
                  </td>
                  <td className="py-2 px-4">{viewReestrItem.id}</td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Xizmat nomi:
                  </td>
                  <td className="py-2 px-4">
                    Yo'qolgan ashyoni davlat xizmatlari markazi orqali izlash
                  </td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">Turi:</td>
                  <td className="py-2 px-4">Buyum</td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Buyum turi:
                  </td>
                  <td className="py-2 px-4">{viewReestrItem?.item.name}</td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Nomi/tavsifi:
                  </td>
                  <td className="py-2 px-4"> {viewReestrItem?.name}</td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">rengi:</td>
                  <td className="py-2 px-4">{viewReestrItem.color}</td>
                </tr>

                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Seria va raqami:
                  </td>
                  <td className="py-2 px-4">
                    {viewReestrItem.itemSerialNumber}
                  </td>
                </tr>

                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">Kodi:</td>
                  <td className="py-2 px-4">{viewReestrItem.code}</td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Yo'qolgan taxminiy hudud:
                  </td>
                  <td className="py-2 px-4">
                    {viewReestrItem.givenRegion.name}
                    <br />
                    {viewReestrItem.lossDistrict.name}
                  </td>
                </tr>
                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Yo'qolgan taxminiy ko'cha:
                  </td>
                  <td className="py-2 px-4"> {viewReestrItem.lossAddress}</td>
                </tr>

                <tr className="border-b">
                  <td className="font-medium py-2 px-4 text-end ">
                    Reestrdagi seriyasi va raqami:
                  </td>
                  <td className="py-2 px-4">{viewReestrItem.serialNumber}</td>
                </tr>
              </tbody>
            </table>
          </div>
        ) : (
          ""
        )}

        {/* Status */}
        <div className="px-6 py-4">
          <h2 className="text-lg font-bold text-gray-700 mb-4">
            REESTRDAGI HOLATI
          </h2>
          <div className="bg-red-500 text-white text-center font-bold py-2 rounded">
            Holati: Yo'qotilgan
          </div>
        </div>
      </div>
    </div>
  );
};

export default ViewReestr;
