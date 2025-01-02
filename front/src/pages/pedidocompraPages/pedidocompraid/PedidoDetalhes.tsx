import SearchLoja from '@/components/SearchLoja';
import Menu from '@/components/Menu';
import ItensPedido from './ItensPedido';
import MenuInformacoes from './MenuInformacoes';
import { useParams } from 'react-router-dom';

function PedidoDetalhes() {
    const { usernameID } = useParams<{ usernameID: string }>();
    return (
        <div className="flex">
        <Menu usuarioID={usernameID || ""} />
        <div className="flex flex-col w-full">
            <SearchLoja />
            <div className="flex h-[92.2vh] bg-[#F5F5F5] justify-center items-center">
                <div className="flex justify-center items-center">
                    <div className="flex flex-col w-[81vw] h-[85vh] bg-slate-100 mt-[1vh] rounded-lg">
                            <ItensPedido/>
                        <div className="flex flex-col justify-center">
                            <MenuInformacoes />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    );
}

export default PedidoDetalhes;
