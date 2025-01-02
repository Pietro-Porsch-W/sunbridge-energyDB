import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "./ui/select";

function SearchLoja() {
    return (
        <div className="flex bg-blue-500 h-[8vh] items-center p-[30px]">
        <div className="flex justify-end w-full">
            <Select>
                <SelectTrigger className="w-[250px]">
                    <SelectValue placeholder="Rede Lojas" />
                </SelectTrigger>
                <SelectContent>
                    <SelectItem value="Rede Lojas">Av.Europa</SelectItem>
                    <SelectItem value="Av.Europa">Av.Europa</SelectItem>
                    <SelectItem value="Av.Europa1">Av.Europa1</SelectItem>
                    <SelectItem value="Av.Europa2">Av.Europa2</SelectItem>
                </SelectContent>
            </Select>
        </div>
    </div>
    );
};

export default SearchLoja;
