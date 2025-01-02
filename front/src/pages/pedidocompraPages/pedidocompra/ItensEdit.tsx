import { Plus } from "lucide-react";
import { Link } from "react-router-dom";

interface ItensEditProps {
    usernameID: string;
}

function ItensEdit({ usernameID }: ItensEditProps) {
    return (
        <div className="flex justify-between items-center p-4 overflow-hidden">
            <span className="text-gray-400 font-semibold pl-[4vh] text-3xl">Pedido de compra</span>
            <div className="flex gap-3 items-center">
                <Link
                    to={`/${usernameID}/pedidocompra/novo`}
                    className="flex w-[6vh] h-[6vh] bg-slate-100 rounded-full items-center justify-center text-blue-600"
                >
                    <Plus />
                </Link>
            </div>
        </div>
    );
}

export default ItensEdit;
